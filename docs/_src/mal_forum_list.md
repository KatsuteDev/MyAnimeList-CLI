---
command: mal forum list <query>
options:
  - flags: [-b, --board]
    type: integer
    desc: The board ID
  - flags: [-s, --subboard]
    type: integer
    desc: The subboard ID
  - flags: [-t, --topic-username]
    type: string
    desc: The topic username
  - flags: [-u, --username]
    type: string
    desc: The author username
  - limit
  - offset
  - csv
  - json
  - jq
---