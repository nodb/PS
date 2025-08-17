data = input()
data_s = data.split("-")

result = 0

for i in data_s[0].split("+"):
  result += int(i)

for i in data_s[1:]:
  for j in i.split("+"):
    result -= int(j)
  
print(result)