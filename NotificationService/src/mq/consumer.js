const mailSender = require('../mail/mailjet')
var amqp = require('amqplib/callback_api');

const consumeFromQueue = async (queueName) => {

    //amqp.connect('amqp://localhost', function (error0, connection) {
    amqp.connect('amqp://rabbitmq', function (error0, connection) {
        if (error0) {
            throw error0;
        }
        connection.createChannel(function (error1, ch) {
            if (error1) {
                throw error1;
            }
            console.log(" [*] Waiting for messages in %s. To exit press CTRL+C", queueName);
            ch.consume(queueName, function (data) {
                //console.log(" [x] Received %s", data.content.toString());
                console.log(" [x] Received %s", data.content);
                console.log(JSON.parse(data.content))
                console.log(process.env.EMAIL)

                let EMAIL = process.env.EMAIL || true
                console.log("Email = " + EMAIL)


                if (EMAIL) {
                    console.log("sendEMAIL")
                    mailSender.sendEmail(JSON.parse(data.content))
                }
                else {
                    mailSender.logToConsole(JSON.parse(data.content))
                }
                //return data.content
            }, { noAck: true }
            );
        });
    });


};

module.exports = { consumeFromQueue }