package com.api.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.springrest.dao.ClaimsRepository;
import com.api.springrest.entities.Claims;

@Component
public class ClaimsService {

	@Autowired
	private ClaimsRepository claimRepository;
	
//	private static List<Claims> list=new ArrayList<>();
//	
//	static {
//		
//		
//		list.add(new Claims(12,"Java Complete","XYZ"));
//		
//		list.add(new Claims(13,"python","ABC"));
//		
//		
//		list.add(new Claims(14,"Java not  Complete","XYsZ"));
//		
//		list.add(new Claims(15,"pythons","AaBC"));
//		
//		
//		
//	}

	public List<Claims> getAllClaimss() {
		
		List<Claims> list= (List<Claims>) this.claimRepository.findAll();
		return list;
		
	}
	
	
	public Claims getClaimsById(int id) {
		Claims claim=null;
		try {
		//claim=list.stream().filter(e->e.getId()==id).findFirst().get();
		
				claim=this.claimRepository.findById(id);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return claim;
	}


//	public static void setList(List<Claims> list) {
//		ClaimsService.list = list;
//	}
//	
	
	
	public Claims addClaims(Claims b) {
		
		Claims result=claimRepository.save(b);
		
		return result;
		
	}
	
	public void deleteClaims(int bid) {
		// TODO Auto-generated method stub

         //Claims claim=null;
		
		//claim=list.stream().filter(e->e.getId()==bid).findFirst().get();
		
         claimRepository.deleteById(bid);
		 //list.remove(claim);
		 
		 
}

	
	public void updateClaims(Claims claim,int claimId)
	{
		
//		list=list.stream().map(b->{
//			
//			if(b.getId()==claimId) {
//				b.setTitle(claim.getTitle());
//				b.setAuthor(claim.getAuthor());
//				
//			}
//			
//			return b;
//		}).collect(Collectors.toList());
//		
//		
		claim.setId(claimId);
		claimRepository.save(claim);
		
		
	}
	
	
	
	
	

}
