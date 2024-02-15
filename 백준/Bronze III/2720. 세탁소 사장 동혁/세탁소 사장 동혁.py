changes = [25, 10, 5, 1] 
T = int(input())

for _ in range(T) :
    C = int(input())
    res = []

    for i in changes :
        res.append(C // i) 
        C = C % i	# 나머지 C에 할당
        
    print(*res)