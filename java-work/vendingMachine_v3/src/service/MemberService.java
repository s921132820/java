package service;

import dto.MemberDto;
import dto.ProductDto;
import dto.SalesDto;
import repository.MachineRepository;

import java.util.List;

import static repository.MachineRepository.salesDto;

public class MemberService{
    // MachineRepository 인스턴스 생성
    MachineRepository machineRepository = new MachineRepository();

    public int insertMemberService(MemberDto memberDto) {
        return machineRepository.insertMember(memberDto);
    }
    public int insertSalesService(SalesDto salesDto) {
        return machineRepository.insertSales(salesDto);
    }

    public int updateMemberService(MemberDto memberDto) {
        return machineRepository.updateMember(memberDto);
    }

    public int updateProductService(ProductDto productDto) {
        return machineRepository.updateProduct(productDto);
    }



    public List<MemberDto> getAllListService() {
        return List.of();
    }

    public List<ProductDto> getProductListService() {
        return machineRepository.getProductList();
    }

    public ProductDto findByProductIdService(int productId) {
        return machineRepository.findByProductId(productId);
    }

    public MemberDto findByMemberIdService(String memberId) {
        return machineRepository.findByMemberId(memberId);
    }

    public boolean loginService(String memberId, String password) {
        return  machineRepository.login(memberId, password);
    }
}

