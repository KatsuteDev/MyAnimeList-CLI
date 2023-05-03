const fs = require("fs");
const path = require("path");

!fs.existsSync(path.join(__dirname, "_site")) || fs.rmSync(path.join(__dirname, "_site"), {recursive: true});