board_size = int(input())
apple_n = int(input())

apple_place = []
for i in range(0,apple_n):
    apple_row, apple_col = input().split()
    apple_row = int(apple_row)
    apple_col = int(apple_col)
    apple_place += [[apple_row,apple_col]]

direction_n = int(input())
direction = []
for i in range(0,direction_n):
    count_dir,dir = input().split()
    count_dir = int(count_dir)
    direction += [[count_dir,dir]]
    
row = 1
col = 1
count = 0

snake_place = [[1,1]]
direction_state = 0
direction_info = [0,1,2,3]
direction_num = 1

while 1:
    
    if len(direction) > 0 :
        if count == int(direction[0][0]):
            if direction[0][1] == "D" : direction_num -= 1
            else : direction_num += 1
            direction.pop(0)
    if direction_num > 3 : direction_num = 0
    if direction_num < 0 : direction_num = 3
    
    if direction_info[direction_num] == 0 : row += 1
    elif direction_info[direction_num] == 1 : col += 1
    elif direction_info[direction_num] == 2 : row -= 1
    else : col -= 1
    count += 1

    if ( row > board_size) or (col > board_size) or ( row < 1 ) or ( col < 1): break
    if [row,col] in snake_place : break

        
    n_pop = False   
    for i in range(0,len(apple_place)):
        if [row,col] == apple_place[i]:
            apple_place.pop(i)
            n_pop = True
            break
            
    if n_pop:
        snake_place += [[row,col]]
    else:
        snake_place += [[row,col]]
        snake_place.pop(0)
    

print(count)