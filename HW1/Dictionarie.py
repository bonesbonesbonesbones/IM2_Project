row = int(input("Enter row: "))
col = int(input("Enter col: "))

dict ={}

for x in range(row):
    print(f"Row {x+1}")
    for y in range(col):
        num = float(input(f"Enter number{y+1}: "))
        dict[(x,y)] = num
    
for x in range(row):
    for y in range(col):
        print(dict[(x, y)], end=" ")
    print()

search = float(input("Search: "))
found = False

for (x, y), val in dict.items():
    if val == search:
        print(f"Number {search} is found at Row {x+1} at Column {y+1}. ")
        found = True

if not found: 
      print(f"Number {search} is not in the Dictionarie.")