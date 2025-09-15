def converter(x):
    yen = x * 146.67
    peso = x * 57.17
    return yen, peso

amount = tuple(float(input(f"({i+1})Enter amount in dollars($): " ))for i in range(3))

print("\nDollar($) | Peso(P) | Yen(Y)")
print("--------------------------------")
for usd in amount:
    peso, yen  = converter(usd)
    print(f"{usd:,.2f} | {peso:,.2f} | {yen:,.2f}")

