// Copyright (C) Katsute 2023

const fs   = require("fs");
const path = require("path");

const https = require("follow-redirects").https;

(async () => {
    /* compress */ {
        const layouts = path.join(__dirname, "_layouts");
        fs.existsSync(layouts) || fs.mkdirSync(layouts);

        https.get(`https://github.com/penibelst/jekyll-compress-html/releases/download/${require("./package.json")["externalDependencies"]["jekyll-compress"]}/compress.html`, (response) => {
            const f = path.join(layouts, "compress.html");
            const OUT = fs.createWriteStream(f, "utf-8");
            response.setEncoding("utf-8");
            response.pipe(OUT);
            OUT.on("finish", () => {
                fs.writeFileSync(f, fs.readFileSync(f, "utf-8").replace(/---.*---/gms, "").replace(/(?:\r?\n)+/gm, "").trim(), "utf-8");
            });
        });
    }
})();