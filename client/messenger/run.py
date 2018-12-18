import requests

headers = {
    'X-Api-Name': "John",
    'X-Api-Key': 'Abc123'
}
response = requests.request("GET", 'http://localhost:5000/', headers=headers)
print(response.text)