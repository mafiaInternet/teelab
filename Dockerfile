# Sử dụng hình ảnh OpenJDK làm cơ sở
FROM maven:3.6.3-openjdk-17
COPY . .
RUN mvc clean package -DskipTests

FROM maven:3.6.3-openjdk-17-slim
COPY --from=build /target/bumblebee-0.0.1-SNAPSHOT.jar bumblebee.jar
# Đặt biến môi trường để xác định tên tệp JAR
EXPOSE 8080
# Đặt entrypoint để chạy ứng dụng
ENTRYPOINT ["java","-jar","/bumblebee.jar"]
