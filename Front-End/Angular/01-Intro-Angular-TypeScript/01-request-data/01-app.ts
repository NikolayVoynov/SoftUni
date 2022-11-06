import RequestData from "./request-data";

const Data = new RequestData(
    "GET",
    "http://google.com",
    "HTTP/1.1",
    "",
  );
  
  console.log(Data);