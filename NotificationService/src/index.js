const rabbitmqConsumer = require('./mq/consumer')
let queue = 'order.notify.app'

let data = rabbitmqConsumer.consumeFromQueue(queue)




//const funcao = async () => {
    // let data = rabbitmqConsumer.consumeFromQueue(queue)
//}
