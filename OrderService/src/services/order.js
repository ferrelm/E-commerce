const Order = require('../models/order')

//var amqp = require('amqplib')

const rabbitmqProducer = require('../mq/producer')

let queue = 'order.notify.app'
let msg = "Oi cara"

exports.newOrder = async (req, res, next) => {

    const order = new Order(req.body)

    try {
        await order.save()
        await rabbitmqProducer.publishToQueue(queue, msg)                  
        res.status(201).send(order)
    } catch (e) {
        console.log(e.message)
        res.status(500).send(e)
    }
}
