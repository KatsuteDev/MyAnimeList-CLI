---
command: mal mangalist update <id>
options:
  - flags: [-S, --status]
    type: string
    desc: |
      The list status

      |status|
      |---|
      |`reading`|
      |`completed`|
      |`on_hold`|
      |`dropped`|
      |`plan_to_read`|
  - flags: [-R, --rereading]
    type: boolean
    desc: If rereading
  - flags: [-s, --score]
    type: integer
    desc: Listing score
  - flags: [-v, --volumes]
    type: integer
    desc: The number of read volumes
  - flags: [-h, --chapters]
    type: integer
    desc: The number of read chapters
  - flags: [-p, --priority]
    type: integer
    desc: The priority
  - flags: [-r, --reread]
    type: integer
    desc: The number of times reread
  - flags: [-v, --reread-value]
    type: integer
    desc: The reread value
  - flags: [-t, --tag]
    type: string
    desc: The tags
  - flags: [-c, --comment]
    type: string
    desc: The comments
  - yes
  - csv
  - json
  - jq
see-also:
  - mal mangalist view
  - mal mangalist delete
---