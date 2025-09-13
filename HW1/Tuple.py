rows = int(input("Enter row: "))
cols = int(input("Enter col: "))


matrix = tuple(
    tuple(float(input(f"Row {r+1} - Enter number{c+1}: ")) for c in range(cols))
    for r in range(rows)
)


for row in matrix:
    print(" ".join(str(num) for num in row))

search = float(input("\nSearch: "))

positions = tuple(
    (r+1, c+1)
    for r, row in enumerate(matrix)
    for c, val in enumerate(row)
    if val == search
)


if positions:
    pos_str = " and ".join(f"Row {r}, Col {c}" for r, c in positions)
    print(f"\nNumber {search} found at {pos_str}.")
else:
    print(f"\nNumber {search} not found.")
