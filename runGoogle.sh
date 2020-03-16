git pull
./mvnw clean package
docker build -t gcr.io/refined-density-271310/datareaderapi .
docker run --rm -p 9090:9090 gcr.io/refined-density-271310/datareaderapi:latest
