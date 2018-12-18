from flask import Flask, request
app = Flask(__name__)

@app.route('/')
def hello_world():
    name_header = request.headers.get('X-Api-Name')
    key_header = request.headers.get('X-Api-Key')
    return "Hello {} - {}".format(name_header, key_header)