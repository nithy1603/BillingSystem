package sg.edu.nus.iss.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



public class BTSFileProcessor {

	public static final String DELIM = "¤";
	public static final String BASE_DIR = "datafiles/";

	public String fileName = null;
	public int columnCount = 0;

	File file = null;
	public FileReader fileReader = null;
	public FileWriter fileWriter = null;

	public BTSFileProcessor(String fileName, int columnCount) throws FileNotFoundException, IOException {

		this.fileName = fileName;
		this.columnCount = columnCount;

		file = new File(BASE_DIR + fileName);
		if (!file.exists()) {
			throw new FileNotFoundException("File not found: " + BASE_DIR + fileName);
		}
	}

	public List<String[]> getAllRecords() throws IOException {
		List<String[]> returnList = new ArrayList<String[]>();

		BufferedReader bufferedReader = null;

		try {
			String line = null;
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			bufferedReader.readLine();

			while ((line = bufferedReader.readLine()) != null) {
				String[] tempArray = getStringArray(line);
				if(tempArray != null) {
					returnList.add(tempArray);
				}
			}	            
		} catch (IOException ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			try {
				if(fileReader != null)
					fileReader.close();
				
				if (bufferedReader != null)
					bufferedReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return returnList;
	}
	
	public String[] getMatchingRecord(int column, String value) throws IOException {
		String[] returnArray = null;

		BufferedReader bufferedReader = null;

		try {
			String line = null;
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			bufferedReader.readLine();

			while ((line = bufferedReader.readLine()) != null) {
				String[] tempArray = getStringArray(line);
				
				if(tempArray != null && column < tempArray.length 
						&& tempArray[column].trim().equalsIgnoreCase(value)) {
					returnArray = tempArray;
					break;
				}
			}	            
		} catch (IOException ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			try {
				if(fileReader != null)
					fileReader.close();
				
				if (bufferedReader != null)
					bufferedReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return returnArray;
	}
	
	public List<String[]> getMatchingRecords(String[] searchCriteria) throws IOException {
		List<String[]> returnList = new ArrayList<String[]>();

		BufferedReader bufferedReader = null;

		try {
			String line = null;
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			bufferedReader.readLine();

			while ((line = bufferedReader.readLine()) != null) {
				String[] tempArray = getStringArray(line);
				
				if(tempArray != null) {
					boolean hasMatch = true; 
					for(int i = 0; i < tempArray.length; i++) {
						if(searchCriteria != null && i < searchCriteria.length 
								&& searchCriteria[i] != null) {
							if(!tempArray[i].equalsIgnoreCase(searchCriteria[i].trim())) {
								hasMatch = false;
								break;
							}
						}
					}
					
					if(hasMatch) {
						returnList.add(tempArray);
					}
				}
			}	            
		} catch (IOException ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			try {
				if(fileReader != null)
					fileReader.close();
				
				if (bufferedReader != null)
					bufferedReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return returnList;
	}
	
	
	
	public void insertRecord(String[] record) throws IOException {
		PrintWriter printWriter = null;

		try {
			fileWriter = new FileWriter(file, true);
			printWriter = new PrintWriter(fileWriter);
			printWriter.println(getFormattedString(record));
		} catch (IOException ex) {
			ex.printStackTrace();
			throw ex;
		} finally {			
			if (fileWriter != null)
				fileWriter.close();
			
			if (printWriter != null) {
				printWriter.flush();
				printWriter.close();
			}
		}
	}

	public void deleteRecords(int column, String value) {

		if(value == null) {
			return;
		}
		
		BufferedReader bufferedReader = null;
		PrintWriter printWriter = null;
		
		File tempFile = new File(file.getAbsolutePath() + ".tmp");
		
		try {

			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(new FileReader(file));

			fileWriter = new FileWriter(tempFile);
			printWriter = new PrintWriter(fileWriter);

			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				
				String[] tempArray = getStringArray(line);
				if(tempArray != null) {
					if(!(column < tempArray.length && value.trim().equalsIgnoreCase(tempArray[column]))) {
						printWriter.println(line);
						printWriter.flush();
					}
				}
			}
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if(fileReader != null)
					fileReader.close();
				
				if (bufferedReader != null)
					bufferedReader.close();
							
				if (fileWriter != null)
					fileWriter.close();
				
				if (printWriter != null)
					printWriter.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		if (!file.delete()) {
			log("Could not delete file");
			return;
		}

		if (!tempFile.renameTo(file)) {
			log("Could not rename file");
		}
	}

	public void deleteRecords(String[] record) {

		BufferedReader bufferedReader = null;
		PrintWriter printWriter = null;
		
		File tempFile = new File(file.getAbsolutePath() + ".tmp");
		
		try {

			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(new FileReader(file));

			fileWriter = new FileWriter(tempFile);
			printWriter = new PrintWriter(fileWriter);

			String lineToDelete = getFormattedString(record);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				if (!line.trim().equals(lineToDelete)) {
					printWriter.println(line);
					printWriter.flush();
				}
			}
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if(fileReader != null)
					fileReader.close();
				
				if (bufferedReader != null)
					bufferedReader.close();
							
				if (fileWriter != null)
					fileWriter.close();
				
				if (printWriter != null)
					printWriter.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		if (!file.delete()) {
			log("Could not delete file");
			return;
		}

		if (!tempFile.renameTo(file)) {
			log("Could not rename file");
		}
	}
	
	public void updateRecord(int primaryKeyColumn, String[] updatedRecord) throws IOException {
		
		if(updatedRecord != null && primaryKeyColumn < updatedRecord.length) {
			deleteRecords(primaryKeyColumn, updatedRecord[primaryKeyColumn]);
			insertRecord(updatedRecord);
		}
	}
	
	public void updateRecord(String[] oldRecord, String[] newRecord) throws IOException {
		
		if(oldRecord != null && newRecord != null) {
			deleteRecords(oldRecord);
			insertRecord(newRecord);
		}
	}

	private String getFormattedString(String[] array) {

		if(array != null && array.length > 0) {

			StringBuffer buffer = new StringBuffer(array[0] == null ? "" : array[0]);
			for(int i = 1; i < array.length; i++) {
				buffer.append(DELIM);
				if(array[i] != null) {
					buffer.append(array[i]);
				}
			}
			return buffer.toString();
		}

		return null;
	}
	
	private String[] getStringArray(String record) {
		
		String[] stringArray = null;
		
		if(record != null && record.trim().length() > 0) {
			stringArray = record.split(DELIM);
			
			if(stringArray != null && stringArray.length < columnCount) {
				String[] tempArray = new String[columnCount];

				for(int i=0; i< stringArray.length; i++) {
					tempArray[i] = stringArray[i];
				}
				
				stringArray = tempArray;
			}
		}
		
		return stringArray;
	}
	
	private void log(Object message) {
		System.out.println(message);
	}	
}
