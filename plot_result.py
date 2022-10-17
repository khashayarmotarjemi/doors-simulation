import json
import matplotlib.pyplot as plt

f = open('result.json')

data = json.load(f)

fig, ax = plt.subplots()

ax.set_ylabel('count')
ax.set_xlabel('run')

for agent in data["results"]:
    resPos = list(map(lambda e: sum(e[0:2]), agent["results"]))
    resNeg = list(map(lambda e: e[3], agent["results"]))

    ax.plot(resPos, label=f'door 1, 2 | agent: 0')
    ax.plot(resNeg, label=f'door 4 | agent: 0')

plt.ylim([10,70])


plt.savefig('result.png',dpi=1200)

ax.legend()   
plt.show()

f.close()