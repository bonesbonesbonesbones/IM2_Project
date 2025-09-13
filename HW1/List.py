row = int(input("Enter row: "))
col = int(input("Enter col: "))

lst =[[]]

for x in range(row):
   if x > 0:
    lst.append([])
   print(f"Row{x+1}")
   for y in range(col):
    num = float(input(f"Enter number{y+1}: "))
    lst[x].append(num)

for x in lst:
  print(" ".join(str(num) for num in x))

search = float(input("Search: "))

found = False

for x, y in enumerate(lst, start=1):
  for y, val in enumerate(y, start=1):
    if val == search:
      print(f"Number {search} is found at Row {x} at Column {y}.")
      found = True

if not found:
  print(f"Number {search} is not in the list.")
    
