#video: https://www.youtube.com/watch?v=zsYIw6RXjfM
#flask is server that is running our API

#import dependencies
from flask import Flask, request, jsonify

#create flask application 
app = Flask (__name__)

#create root (location on api where we can go to get some kind of data)
# @app.route("/") #this is a decorator that tells flask what to do when we are at the root location
# def home():
#     return "Home"

# GET used to retrieve some value from server 
# POST used to create something new
# PUT used to alter or modify existing data
# DELETE used to delete data from database


#user_id is a path parameter
@app.route("/get-user/<user_id>")
def get_user(user_id):

    user_data = {
        "user_id": user_id,
        "name": "Alan Vo",
        "email": "bvo101968@gmail.com"
    }

    #query parameter is extra value that is included after the main path
    extra = request.args.get("extra")
    if extra:
        user_data["extra"] = extra

    #everytime return data from API, use json
    return jsonify(user_data), 200


@app.route("/create-user", methods=["POST"])
def create_user():
    data = request.get_json() #get all data from the request

    return jsonify(data), 201 




if (__name__ == "__main__"):
    app.run(debug=True) #this runs our flask server