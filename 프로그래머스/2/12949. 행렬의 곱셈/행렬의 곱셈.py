def solution(arr1, arr2):
    answer = []
    for i in range(len(arr1)):
        li = []
        for _ in range(len(arr2[0])):
            li.append(0)
        
        answer.append(li)

    for row in range(len(arr1)):
         for col in range(len(arr2[0])):
              for i in range(len(arr2)):
                   answer[row][col] += arr1[row][i] * arr2[i][col]
        
    return answer