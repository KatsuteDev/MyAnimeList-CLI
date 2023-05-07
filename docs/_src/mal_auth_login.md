---
command: mal auth login
options:
  - flags: [-t, --token]
    type: string
    desc: Authenticate using a token
  - flags: [-c, --client]
    type: string
    desc: Authenticate using a client id
  - flags: [-s, --secret]
    desc: Client secret if authenticating with client id
  - flags: [-w, --web]
    desc: Authenticate using the browser
see-also:
  - mal auth logout
---
Authenticate with the MyAnimeList API.