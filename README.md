# monitorowanie-jednostek-morskich

https://wiki.barentswatch.net/display/BO/Application+registration+and+authentication

API
https://www.barentswatch.no/bwapi/openapi/index.html?urls.primaryName=AIS%20API#/

login:
https://id.barentswatch.no/Account/Login?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3Dbwspa%26redirect_uri%3Dhttps%253A%252F%252Fwww.barentswatch.no%252Fminside%252Foidc_redirect_uri%26response_type%3Dcode%26scope%3Dopenid%2520api%26state%3D0b31d08fbd3d4e17b72cda8751c98971%26code_challenge%3DYJAcQ26AGYZpu4gveO59pddcxNnV20MyBkw9fIMnyDM%26code_challenge_method%3DS256%26response_mode%3Dquery

token:
POST --header "Content-Type: application/x-www-form-urlencoded" -d "client_id=YOUR_CLIENT_ID&scope=api&client_secret=YOUR_CLIENT_SECRET&grant_type=client_credentials" https://id.barentswatch.no/connect/token

data:
https://www.barentswatch.no/bwapi/v2/geodata/ais/compactopenpositions?Xmin=10.09094&Xmax=10.67047&Ymin=63.3989&Ymax=63.58645'

Authorization:  Token
