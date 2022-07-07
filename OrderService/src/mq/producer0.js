//var amqp = require('amqplib/callback_api');
var amqp = require('amqplib')

let instance;

class MessageBroker {
    async init() {

        try {
        this.connection = await amqp.connect('amqp://localhost')
        this.channel = await this.connection.createChannel()
        return this
        }
        catch(err) {

            console.error(err);
        }

    }

    async publishToQueue(queue, msg) {
        console.log("teste")
        if (!this.connection) {
          await this.init();
        }
        await this.channel.assertQueue(queue, {durable: true});
        this.channel.sendToQueue(queue, msg)
        console.log(" [x] Sent %s", msg);
      }
}

MessageBroker.getInstance = async function() {
    if (!instance) {
      const broker = new MessageBroker()
      instance = broker.init()
    }
    return instance
  };


module.exports = { MessageBroker }


