class Solution:
    def calPoints(self, ops: List[str]) -> int:
        history = []
        for o in ops:
            if o == 'C':
                history.pop()
            elif o == 'D':
                history.append(history[-1] * 2)
            elif o == '+':
                history.append(history[-1] + history[-2])
            else:
                history.append(int(o))
        return sum(history)
                