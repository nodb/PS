import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

abstract class MagicSquare {
	protected int[][] magic;
	protected int n;

	public MagicSquare(int n) {
		this.n = n;
		magic = new int[n][n];
	}

	public String print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(magic[i][j]).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	private Object isMagic() {
		int[] mgc = new int[2 * n + 2];
		for (int i = 0; i < n; i++) {
			mgc[i] = sumrow(i);
			mgc[i + n] = sumcol(i);
		}
		mgc[2 * n] = sumdia();
		mgc[2 * n + 1] = sumundia();
		for (int i = 0; i < n; i++) {
			if (mgc[0] == 0 || mgc[0] != mgc[i]) {
				return false;
			}
		}
		return true;
	}

	private int sumundia() {
		int tot = 0;
		for (int i = 0; i < n; i++) {
			tot += magic[i][n - i - 1];
		}
		return tot;
	}

	private int sumdia() {
		int tot = 0;
		for (int i = 0; i < n; i++) {
			tot += magic[i][i];
		}
		return tot;
	}

	private int sumcol(int c) {
		int tot = 0;
		for (int i = 0; i < n; i++) {
			tot += magic[i][c];
		}
		return tot;
	}

	private int sumrow(int r) {
		int tot = 0;
		for (int i = 0; i < n; i++) {
			tot += magic[r][i];
		}
		return tot;
	}

	public abstract void make();

	public int[][] getMagic() {
		return magic;
	}
}

class OddMagicSquare extends MagicSquare{
	public OddMagicSquare(int n) {
		super(n);
	}

	public OddMagicSquare() {
		this(3);
	}

	@Override
	public void make() {
		int r = 0;
		int c = n / 2;
		for (int i = 1; i < n * n + 1; i++) {
			magic[r][c] = i;
			int tempR = r;
			int tempC = c;
			if (r - 1 < 0) {
				r = n - 1;
			} else {
				r--;
			}
			if (c - 1 < 0) {
				c = n - 1;
			} else {
				c--;
			}
			if (magic[r][c] != 0) {
				r = tempR + 1;
				c = tempC;
			}
		}
	}

	public int[][] getMagic() {
		return magic;
	}
}

class FourMagicSquare extends MagicSquare{
	public FourMagicSquare(int n) {
		super(n);
	}

	public FourMagicSquare() {
		this(4);
	}
	
	@Override
	public void make() {
		makeS();
		makeR();
	}

	private void makeR() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((i >= 0 && i < n / 4) || (i >= n / 4 * 3)) {
					if (j >= n / 4 && j < n / 4 * 3) {
						magic[i][j] = n * n - (i * n + j);
					}
				} else {
					if ((j >= 0 && j < n / 4) || (j >= n / 4 * 3)) {
						magic[i][j] = n * n - (i * n + j);
					}
				}
			}
		}
	}

	private void makeS() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				magic[i][j] = i * n + j + 1;
			}
		}
	}
}

class SixMagicSquare extends MagicSquare {
	public SixMagicSquare(int n) {
		super(n);
	}

	public SixMagicSquare() {
		this(6);
	}

	@Override
	public void make() {
		makeA();
		makeB();
		makeCD();
		makeMul();
		makeOdd();
	}

	private void makeOdd() {
		OddMagicSquare odd = new OddMagicSquare(n / 2);
		odd.make();
		int[][] oddMagic = odd.getMagic();
		int m = n / 2;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				magic[i][j] += oddMagic[i][j];
				magic[i][j + m] += oddMagic[i][j];
				magic[i + m][j] += oddMagic[i][j];
				magic[i + m][j + m] += oddMagic[i][j];
			}
		}
	}

	private void makeA() {
		int m = n / 2;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m / 2; j++) {
				if (i != m / 2)
					magic[i][j] = 3;
				else
					magic[i][j + 1] = 3;
			}
		}
	}

	private void makeB() {
		int m = n / 2;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				magic[i][j + m] = 1;
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m - (m / 2 - 1); j++) {
				magic[i][j + m] = 2;
			}
		}
	}

	private void makeCD() {
		int m = n / 2;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if (magic[i][j] == 0)
					magic[i + m][j] = 3;
				else
					magic[i + m][j] = 0;
				if (magic[i][j + m] == 1)
					magic[i + m][j + m] = 2;
				else
					magic[i + m][j + m] = 1;
			}
		}
	}

	private void makeMul() {
		int m = n / 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				magic[i][j] *= (m * m);
			}
		}
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		MagicSquare magic = null;
		if (n % 2 == 1) {
			magic = new OddMagicSquare(n);
		} else if (n % 4 == 0) {
			magic = new FourMagicSquare(n);
		} else if (n % 4 == 2) {
			magic = new SixMagicSquare(n);
		}
		
		magic.make();
		
		// StringBuilder로 생성된 문자열을 한 번에 출력
		bw.write(magic.print());
		bw.flush();
		
		br.close();
		bw.close();
	}	
}