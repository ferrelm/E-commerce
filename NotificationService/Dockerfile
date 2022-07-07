FROM node:lts-alpine
WORKDIR /notificationservice
COPY package.json .
RUN npm config set https-proxy http://userlmf:passlmf@proxyIP:proxyPort
RUN npm install
COPY src ./src
ENTRYPOINT ["npm","start"]



# FROM node:lts-alpine
# WORKDIR /notificationservice
# COPY . .
# RUN npm config set proxy http://userlmf:passlmf@proxyIP:proxyPort
# RUN npm config set https-proxy http://userlmf:passlmf@proxyIP:proxyPort 
# # RUN npm config set proxy ${HTTP_PROXY}
# # RUN npm config set https-proxy ${HTTPS_PROXY}
# # RUN --mount=type=secret,id=mysecret export $(cat /run/secrets/mysecret | xargs) \
# #     && npm install \
# # RUN npm install
# # CMD ["npm", "start"]
