### 1. Why did you choose the board size for your finalized table?
I chose a board size of __300__ because it ran relatively quickly in both of my testing scenarios and provided results similar to larger board sizes (500, 1000), but took less time to run.
### 2. Why did you choose the number of repetitions size for your finalized table?
I chose __150__ repetitions when testing for 5% intervals because running the simulation repeatedly with this number of repetitions gave me fairly similar results every time. Additionally unlike higher numbers of repetitions it ran in a reasonable amount of time with decently large boards. And __250__ repetitions when testing for 1% intervals because there were less test cases and I wanted to focus on precision when identifying the density value with the maximum burn time.
### 3. What did your testing show about changing the board size?
My testing showed that increasing the board size prolonged the run time but running board sizes up to about 650 could be done in a reasonable enough time with 150 repetitions meaning that the run time of the algorithm was not exponential as this could not have been plausible otherwise.
### 4. Knowing that there were differences based on boardsize, what was the relationship between the board size and the maximum burn time? How did you test this?
An increased board size did not change the density value with the maximum burn time as converged at 60% for board sizes larger than 200. However, the maximum burn time (for that value and others) changed significantly, the average burn times with boards with larger sizes were significantly higher than those on smaller boards. 
### 5. What density of trees yields the maximum burn time?
__60% Density__

## TABLES
### Table 1: 5% Intervals from 5% - 95% Density
#### Board Size 300, 150 Repetitions

| Density  | Avg Burn Time  |
| ------------- |:---------|        
|5%| 1.7066666666666668|
|10%| 2.5733333333333333|
|15%| 3.96|
|20%| 5.006666666666667|
|25%| 6.693333333333333|
|30%| 8.686666666666667|
|35%| 12.526666666666667|
|40%| 16.293333333333333|
|45%| 25.933333333333334|
|50%| 43.49333333333333|
|55%| 110.29333333333334|
|60%| 706.8466666666667|
|65%| 475.58666666666664|
|70%| 409.23333333333335|
|75%| 376.1333333333333|
|80%| 354.4|
|85%| 337.7|
|90%| 324.75333333333333|
|95%| 313.58666666666664|

### Table 2: 1% Interval from 55%-64% Density
#### Board Size 300, 250 Repetitions

| Density  | Avg Burn Time  |
| ------------- |:---------|
|55%| 107.75333333333333|
|56%| 138.14|
|57%| 192.42|
|58%| 327.2733333333333|
|59%| 526.8333333333334|
|60%| 722.7666666666667|
|61%| 666.62|
|62%| 579.52|
|63%| 530.0533333333333|
|64%| 501.4266666666667|
