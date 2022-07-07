const mongoose = require('mongoose')

const orderSchema = new mongoose.Schema({
  productId: Number,
  quantity: Number,
  date: Date,
  custumer: {
      name: String,
      email: String
  }
});

const Order = mongoose.model('Order', orderSchema);

module.exports = Order