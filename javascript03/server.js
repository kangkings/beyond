const express = require("express");

const app = express();

//자바로 치면 controller 메소드 하나
//HTTP Get요청 받아서 처리
app.get("/test", async (req, res) => {
    console.log("test");
    res.send("테스트");
})


app.post("/broadcast",({data}, res) => {
    console.log(data);
    res.send("ok");
})

//자바로 치면 main메소드
//8080포트로 서버 실행
app.listen(8080, () => {
    console.log("Server Started");
});