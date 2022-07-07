const express = require('express')
const app = express()
const port = 3000
const rabbitmqConsumer = require('./mq/consumer')
let queue = 'vdf.express.app'

app.use(express.json());

app.listen(port, async () => {
  console.log(`Example app listening on port ${port}`)
  await rabbitmqConsumer.consumeFromQueue(queue);
})