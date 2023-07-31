# Requirements

JDK 11

GRADLE 8.1.1

SPRING BOOT 2.7.13

POSTGRES 15.3

## Docker Configuration

-Postgres Image: docker pull postgres:15.3

-Postgres Container: docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=root -e POSTGRES_USER=postgres -e POSTGRES_DB=bank -v C:\postgres_container_data:/var/lib/postgresql/data --name=postgres_container postgres:15.3

-Spring boot App Image: docker build -t bank_img  .

-Spring boot App Container: docker run -d -p 8888:8888 --name=bank_container bank_img

