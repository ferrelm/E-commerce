const express = require('express')
require('./db/mongoose')
const orderRouter = require('./routers/order')
//const rabbitmqProducer = require('./mq/producer')

const cors = require('cors')


const app = express()
const port = process.env.PORT || 3000

app.use(cors({origin: '*'}))
app.use(express.json())
app.use(orderRouter)
//app.use(rabbitmqProducer)


app.listen(port, () => {
    console.log('Server is up on port ' + port)
})