var SubjectLib = {
	
	//获得当前的试题 2017-03-21 add 
	getCurrentSubject:function(subjectID,smallSubjectID){
		var subject = {};
		
		if(testing.currentSubjects){
			for(var i=0;i<testing.currentSubjects.length;i++){
				var currentSubject = testing.currentSubjects[i];
				if(currentSubject.smallSubjects.length == 0){
					//不含小题
					if(currentSubject.subjectID == subjectID){
						subject.partID = currentSubject.partID;
						subject.partIndex = currentSubject.partIndex;
						subject.subjectID = currentSubject.subjectID;
						subject.subjectIndex = currentSubject.subjectIndex;
						subject.smallSubjectID = currentSubject.subjectID;
						subject.smallSubjectIndex = currentSubject.subjectIndex;
						subject.subjectScore = currentSubject.subjectScore;
						subject.subjectTplType = currentSubject.subjectTplType;
						subject.subjectAnswer = currentSubject.subjectAnswer;
						return subject; 
					}
				}else{
					//含有小题
					if(currentSubject.subjectID == subjectID){
						subject.partID = currentSubject.partID;
						subject.partIndex = currentSubject.partIndex;
						subject.subjectID = currentSubject.subjectID;
						subject.subjectIndex = currentSubject.subjectIndex;
						
						for(var i=0;i<currentSubject.smallSubjects.length;i++){
							var currentSmallSubject = currentSubject.smallSubjects[i];
							if(currentSmallSubject.subjectID == smallSubjectID){
								subject.smallSubjectID = currentSmallSubject.subjectID;
								subject.smallSubjectIndex = currentSmallSubject.subjectIndex;
								subject.subjectScore = currentSmallSubject.subjectScore;
								subject.subjectTplType = currentSmallSubject.subjectTplType;
								subject.subjectAnswer = currentSmallSubject.subjectAnswer;
								return subject;
							}
						} 
					}
				}
			}
		}
	}
}