const express = require('express')
const router = new express.Router()

// var cors = require('cors');
// router.use(cors());

const orderController = require('../controllers/order')
//const Order = require('../models/order')

router.post('/orders', orderController.newOrder)

// const axios = require('axios');

// router.post('/orders', (req, res) => {
//     axios.get('/')
//    .then((response) => {
//         console.log(response.data);
//         console.log(response.status);
//         console.log(response.statusText);
//         console.log(response.headers);
//         console.log(response.config);
//     }).catch(err => console.log(err))
// })



module.exports = router