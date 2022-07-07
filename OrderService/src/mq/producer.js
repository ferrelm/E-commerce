var amqp = require('amqplib/callback_api');

const publishToQueue = async (queue, msg) => {

    //amqp.connect('amqp://localhost', function (error0, connection) {
    amqp.connect('amqp://rabbitmq', function (error0, connection) {
        if (error0) {
            throw error0;
        }
        connection.createChannel(function (error1, channel) {
            if (error1) {
                throw error1;
            }

            console.log(queue)

            channel.assertQueue(queue, {
                durable: true
            });
            channel.sendToQueue(queue, Buffer.from(msg));

            console.log(" [x] Sent %s", msg);
        });
    });

};

module.exports = { publishToQueue }
