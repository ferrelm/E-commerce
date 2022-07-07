//https://janmolak.com/node-js-axios-behind-corporate-proxies-8b17a6f31f9d
//https://masteringjs.io/tutorials/axios/create-post


const Order = require('../models/order')
const axios = require('axios');
var tunnel = require('tunnel')

const rabbitmqProducer = require('../mq/producer')

let queue = 'order.notify.app'

exports.newOrder = async (req, res, next) => {

    const order = new Order(req.body)

    const agent = tunnel.httpsOverHttp({
        proxy:
        {
            host: "10.74.50.1",
            port: "80",
            auth: process.env.AUTH
        }
    });

    let endpoint = String('/' + req.body.productId)
    //let base = String('http://localhost:8081/products/' + req.body.productId)
    let base = String('http://productcatalog:8081/products/' + req.body.productId)
    console.log("endpoint = " + endpoint)
    let quantity = req.body.quantity
    console.log("quantity = " + quantity)

    let TUNNEL = process.env.TUNNEL || true
    console.log("Tunnel = " + TUNNEL)

    if (TUNNEL) {
        const getInstance = axios.create({
            url: endpoint,
            baseURL: base,
            method: 'GET',
            httpsAgent: agent,
            proxy: false,
        });
        const patchInstance = axios.create({
            url: endpoint,
            baseURL: base,
            method: 'PATCH',
            httpsAgent: agent,
            proxy: false,
        });

        try {
            await getInstance.request()
                .then(response => {
                    console.log(response.data.name)
                    if (response.data.stock >= quantity) {
                        console.log("OK")

                        let updatedStock = response.data.stock - quantity
                        console.log(updatedStock)

                        patchInstance.request({
                            data: {
                                stock: updatedStock
                            }
                        })
                    }
                }).catch(error => console.log('error', error));

            await order.save()
            await rabbitmqProducer.publishToQueue(queue, Buffer.from(JSON.stringify(req.body)))
            res.status(201).send(order)
        } catch (e) {
            console.log(e.message)
            res.status(500).send(e)
        }
    }
    else {
        const getInstance = axios.create({
            url: endpoint,
            baseURL: base,
            method: 'GET',
        });
        const patchInstance = axios.create({
            url: endpoint,
            baseURL: base,
            method: 'PATCH',
        });

        try {

            await getInstance.request()


                // .then(response => response.data)
                // .then(result => console.log(result))
                // .catch(error => console.log('error', error));

                .then(response => {
                    console.log(response.data.name)
                    if (response.data.stock >= quantity) {
                        console.log("OK")

                        let updatedStock = response.data.stock - quantity
                        console.log(updatedStock)

                        patchInstance.request({
                            data: {
                                stock: updatedStock
                            }
                        })
                    }
                }).catch(error => console.log('error', error));

            await order.save()
            await rabbitmqProducer.publishToQueue(queue, Buffer.from(JSON.stringify(req.body)))
            res.status(201).send(order)
        } catch (e) {
            console.log(e.message)
            res.status(500).send(e)
        }


    }


}
