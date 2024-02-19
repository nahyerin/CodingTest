def solution(n):
    answer_list = []
    for i in range(1, n+1):
        # n을 i로 나눠서 나머지가 0인지를 확인
        if n%i == 0:
            # 나머지가 0인 경우 answer_list에 약수 값을 append
            answer_list.append(i)
    # 모든 약수의 합을 answer에 할당
    answer = sum(answer_list)
    return answer