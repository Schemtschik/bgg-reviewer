# https://www.kaggle.com/mrpantherson/board-game-data/data
import pandas as pd
import psycopg2

df = pd.read_csv("data.csv")

con = psycopg2.connect(
  database="boad_games", 
  user="", 
  password="", 
  host="localhost", 
  port="5432"
)

print("Database opened successfully")
for row in df:
	cur = con.cursor()
	cur.execute(
	#TODO
	)

con.commit()  

con.close()