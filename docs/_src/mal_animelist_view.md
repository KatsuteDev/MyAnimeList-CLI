---
command: mal animelist view <id>
options:
  - user
  - flags: [-S, --status]
    type: string
    desc: |
      Status to filter

      |status|
      |---|
      |`watching`|
      |`completed`|
      |`on_hold`|
      |`dropped`|
      |`planned_to_watch`|
  - flags: [-s, --sort]
    type: string
    desc: |
      Sort order

      |value|
      |---|
      |`score`|
      |`updated_at`|
      |`title`|
      |`start`|
  - limit
  - offset
  - nsfw
  - csv
  - json
  - jq
  - web
see-also:
  - mal animelist update
  - mal animelist delete
---
View a user Anime listing.