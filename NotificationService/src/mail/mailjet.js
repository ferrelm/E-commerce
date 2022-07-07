//https://www.npmjs.com/package/node-mailjet

const Mailjet = require('node-mailjet')

const MJ_APIKEY_PUBLIC = "7fe51c542927d6865d26f3af1482afe4"
const MJ_APIKEY_PRIVATE = "1a8400548b6fc8697a4f7cdd16a63b5d"


//console.log(process.env.MJ_APIKEY_PUBLIC)

//let PASS = process.env.PASS

const mailjet = Mailjet.apiConnect(
	MJ_APIKEY_PUBLIC,
	MJ_APIKEY_PRIVATE,
	{
		config: {},
		options: {
			proxy: {
				protocol: 'http',
				host: 'proxyIP',
				port: '80',
				auth: {
					username: 'userlmf',
					password: 'passlmf'
				}
			}
		}
	}
);



function sendEmail(req) {

	console.log("MAIL")
	console.log(req.custumer.email)
	console.log(req.custumer.name)

	return mailjet
		.post("send", { 'version': 'v3.1' })
		.request({
			Messages: [
				{
					From: {
						"Email": "grupo09@izy.pt",
						"Name": "Grupo 09"
					},
					To: [
						{
							Email: req.custumer.email,
							Name: req.custumer.name
						}
					],
					Subject: "Obrigado pela sua encomenda!",
					TextPart: "Caro " + req.custumer.name + ", A sua encomenda foi processada com sucesso",
					HTMLPart: "<h3>Dear passenger 1, welcome to <a href=\"https://www.mailjet.com/\">Mailjet</a>!</h3><br />May the delivery force be with you!"
				}
			]
		})
		.then((res) => {
			console.log(res.body[0])
			console.log(res.body)
		}).catch(error => {
			console.log(error)
		})



}


function logToConsole(req) {

	const json = {
		Messages: [
			{
				From: {
					"Email": "grupo09@izy.pt",
					"Name": "Grupo 09"
				},
				To: [
					{
						Email: req.custumer.email,
						Name: req.custumer.name
					}
				],
				Subject: "Obrigado pela sua encomenda!",
				TextPart: "Caro " + req.custumer.name + ", A sua encomenda foi processada com sucesso",
				HTMLPart: "<h3>Dear passenger 1, welcome to <a href=\"https://www.mailjet.com/\">Mailjet</a>!</h3><br />May the delivery force be with you!"
			}
		]
	}

	console.log(json);
	console.log(json.Messages[0]);

}


module.exports = { sendEmail, logToConsole }