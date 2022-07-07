FROM node:lts-alpine
WORKDIR /orderservice
COPY package.json .
RUN npm config set https-proxy http://userlmf:passlmf@10.74.50.1:80
RUN npm install
COPY src ./src
ENTRYPOINT ["npm","start"]


# FROM node:lts-alpine
# # ARG HTTP_PROXY
# # ARG HTTPS_PROXY
# WORKDIR /orderservice
# COPY . .
# RUN npm config set proxy http://userlmf:passlmf@10.74.50.1:80
# RUN npm config set https-proxy http://userlmf:passlmf@10.74.50.1:80
# # RUN npm config set proxy $HTTP_PROXY
# # RUN npm config set https-proxy $HTTPS_PROXY
# # RUN --mount=type=secret,id=mysecret export $(cat /run/secrets/mysecret | xargs) \
# #     && npm install \
# # RUN npm install
# RUN npm install
# EXPOSE 3000
# # CMD ["npm", "start"]