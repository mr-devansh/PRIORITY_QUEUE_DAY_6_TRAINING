import heapq

def min_range():
    T = int(input().strip())
    testcases = []
    for _ in range(T):
        N, M = map(int, input().strip().split())
        array = list(map(int, input().strip().split()))
        testcases.append((N, M, array))

    results = []
    for t in range(T):
        N, M, array = testcases[t]
        queue = [-num for num in array]
        heapq.heapify(queue)
        min_value = -max(queue)
        for _ in range(M):
            largest = -heapq.heappop(queue)
            if largest <= 3:
                heapq.heappush(queue, -largest)
                break
            min_value = min(min_value, largest // 2)
            heapq.heappush(queue, -(largest // 2))
        range_ = -min(queue) - min_value
        results.append(range_)
    return results

val=min_range()
for i in val:
    print(i)