import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        int[][] island = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                island[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println(islandPerimeter(island));
    }
	static int count=0;

    public static int islandPerimeter(int[][] grid) {
        // your code here
		int n=grid.length;
		int m=grid[0].length;
		for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++){
					if(grid[i][j]==1){
						dfs(grid,i,j);
						return count;
					}
				}
			}
		return count;
    }
	private static void dfs(int[][]a,int i,int j){
		if(i<0 || j<0 || i>=a.length || j>=a[0].length || a[i][j]==0)
		{
			count++;
			return;
		}
		if(a[i][j]==-1)
			return;
		a[i][j]=-1;
		dfs(a,i+1,j);
		dfs(a,i-1,j);
		dfs(a,i,j+1);
		dfs(a,i,j-1);
	}
	
}
