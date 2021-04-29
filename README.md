# forum-api
Spring Boot API REST

# Heroku
- http://desenv-forum.herokuapp.com/topicos

# Criado durante os cursos:
- Spring Boot API REST: Construa uma API
- Spring Boot API Rest: Segurança da API, Cache e Monitoramento
- Spring Boot e Teste: Profiles, Testes e Deploy

# Run PROD
- mvn clean package
- cd target/
- java -jar -Dspring.profiles.active=prod -DFORUM_DATABASE_DRIVER=org.h2.Driver -DFORUM_DATABASE_URL=jdbc:h2:mem:api-forum -DFORUM_DATABASE_USERNAME=sa -DFORUM_DATABASE_PASSWORD= -DFORUM_JWT_SECRET=123456 forum.jar

# Docker
- Gerar imagem: docker build -t desenv/forum .
- Ver imagem: docker image list
- Rodar imagem: docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE='prod' -e FORUM_DATABASE_DRIVER='org.h2.Driver' -e FORUM_DATABASE_URL='jdbc:h2:mem:api-forum' -e FORUM_DATABASE_USERNAME='sa' -e FORUM_DATABASE_PASSWORD='' -e FORUM_JWT_SECRET='123456' desenv/forum