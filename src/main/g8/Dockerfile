FROM nginx:1.23

COPY ci/nginx.conf /etc/nginx/nginx.conf

RUN rm /usr/share/nginx/html/index.html

COPY dist /usr/share/nginx/html

EXPOSE 80

ENTRYPOINT ["nginx", "-g", "daemon off;"]
