import fs from "fs";
import axios from "axios";

clearDir("./services")
clearDir("./events")
clearDir(".domains")
clearDir("./async-api-files")

const urls = [
  "http://localhost:8080",
  "http://localhost:8081",
  "http://localhost:8082",
  "http://localhost:8083"
]

const baseUrls = urls.map(url => axios.create({ baseURL: url }))

for (const baseUrl of baseUrls) {
  const response = await baseUrl.get("/springkafkadoc/yaml");
  const url = baseUrl.defaults.baseURL
  fs.writeFileSync(`./async-api-files/${url.substring(url.lastIndexOf("/") + 1)}.yml`, response.data);
}


function clearDir(directory) {
  fs.rmSync(directory, { recursive: true, force: true });
  if (!fs.existsSync(directory)) {
    fs.mkdirSync(directory);
  }
}
