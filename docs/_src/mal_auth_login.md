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
examples:
  - |
    # login using interactive setup
    $ mal auth login
  - |
    # login using web browser
    $ mal auth login --web
  - |
    # login using token
    $ mal auth login --token "???"
---
Authenticate with the MyAnimeList API.