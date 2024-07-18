class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        posX = set()
        posY = set()

        for i in range(0,len(matrix)):
            for j in range(0,len(matrix[0])):
                if matrix[i][j] == 0 :
                    posX.add(i)
                    posY.add(j)
        
        for i in posX:
            for j in range(0,len(matrix[0])):
                matrix[i][j] =0

        for i in posY:
            for j in range(0,len(matrix)):
                matrix[j][i]=0
