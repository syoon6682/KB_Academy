package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

시간 초과
배열 추출 사용해야한느지?
*/
public class test {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine(), "");
        String str = st.nextToken();

        String[] dna = str.split("");


        st = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int count = 0;
        int i = 0;
        while (i + P -1 < S ) {

            int A=0;
            int C=0;
            int G=0; 
            int T=0;
            for(int k = i; k < i+P; k++) {
                if(dna[k].equals("A"))
                    A++;
                if(dna[k].equals("C"))
                    C++;
                if(dna[k].equals("G"))
                    G++;
                if(dna[k].equals("T"))
                    T++;
            }
            if((a<= A)&&(g<=G)&&(c<=C)&&(t<=T))
                count++;
            i++;
        }


        System.out.println(count);
    }
}