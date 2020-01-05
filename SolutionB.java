class SolutionB {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int CWIndex = 0;
        int count = 0;
        int row = 0;
        int col = 0;
        
        int wordLength  = -1;
        while(row < rows)
        {
            while(CWIndex < sentence.length && row < rows)
            {
                wordLength = sentence[CWIndex].length();
                if(col + wordLength - 1 < cols)
                {
                    col += wordLength - 1;
                    CWIndex++;
                    if(cols - (col + 1) <= 1)
                    {
                        row++;
                        col = 0;
                    }
                    else
                    {
                        col += 2;
                    }
                }
                else
                {
                    if(col == 0)
                    {
                        return 0;
                    }
                    else
                    {
                        row++;
                        col = 0;
                    }
                }
            }
            if(CWIndex == sentence.length)
            {
                count++;
                CWIndex = 0;
            }
        }
        return count;
    }
}